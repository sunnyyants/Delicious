package com.actions;

import com.models.Genre;
import com.models.LineItem;
import com.models.Menu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GenreService;
import com.service.LikesService;
import com.service.LineItemService;
import com.service.MenuService;
import com.service.impl.GenreServiceImpl;
import com.service.impl.LikesServiceImpl;
import com.service.impl.LineItemServiceImpl;
import com.service.impl.MenuServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunny on 4/12/14.
 */
public class MenuAction extends ActionSupport{

    private Integer id;
    private Integer userId;
    private String name;
    private File image;
    private String imageURL;
    private String imageFileName;
    private String imageContentType;
    private String description;
    private Float price;
    private Integer genreId;
    private List<Genre> genres;
    private Genre genre;
    private Float average;

    private HashMap<Integer, Boolean> choices;


    private List<Menu> listOfMenu;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public File getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setListOfMenu(List<Menu> listOfMenu) {
        this.listOfMenu = listOfMenu;
    }

    public List<Menu> getListOfMenu() {
        return listOfMenu;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setChoices(HashMap<Integer, Boolean> choices) {
        this.choices = choices;
    }

    public HashMap<Integer, Boolean> getChoices() {
        return choices;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public Float getAverage() {
        return average;
    }

    public String saveMenu(){
        MenuService menuService = new MenuServiceImpl();
//        GenreService genreService = new GenreServiceImpl();
//        this.genres = genreService.listOfGenre();
        Menu menu = new Menu();
        if(this.name == null || this.name.trim().length() == 0){
            this.addFieldError("name","name cannot be null");
            return ERROR;
        }
        menu.setName(this.name);
        menu.setDescription(this.description);
        menu.setPrice(this.price);
        menu.setAverage(new Float(0.1));
        if(image != null){
            String realPath = ServletActionContext.getServletContext().getRealPath("/menuImages");
            File imageFile = new File(new File(realPath),imageFileName);
            try {
                if(!imageFile.getParentFile().exists()){
                    imageFile.getParentFile().mkdir();
                }
                FileUtils.copyFile(image,imageFile);
            } catch (IOException e) {
                e.printStackTrace();
                this.addActionError(e.getMessage());
                return "EXCEPTIONS";
            }
            this.imageURL = this.imageFileName;
            menu.setImageURL(this.imageURL);

        }
        menuService.saveMenu(this.genreId,menu);
        return SUCCESS;
    }

    public String deleteMenu(){
        MenuService menuService = new MenuServiceImpl();
        menuService.deleteMenu(this.id);
        return SUCCESS;
    }

    public String findAllMenu(){
        MenuService menuService = new MenuServiceImpl();
        LikesService likesService = new LikesServiceImpl();
        GenreService genreService = new GenreServiceImpl();
        List listOfAverage = likesService.getAllAverageScore();
        List<Menu> allMenus = menuService.findAllMenu();
        List<Genre> listOfgenre = new ArrayList<Genre>();
        for(int i = 0; i < listOfAverage.size(); i++){
            List temp = (List) listOfAverage.get(i);
            Integer menuId = ((Menu)(temp.get(0))).getId();
            double avg = (Double) temp.get(1);
            float average = (float) avg;
            menuService.updateAverage(menuId,average);
        }

        for(int i = 0; i < allMenus.size(); i++){
            Menu menu = allMenus.get(i);
            listOfgenre.add(genreService.GenreById(menu.getGenre().getId()));
        }
        genres = listOfgenre;
        listOfMenu = menuService.findAllMenu();
        return SUCCESS;
    }

    public String updateMenu(){
        MenuService menuService = new MenuServiceImpl();
//        GenreService genreService = new GenreServiceImpl();
//        genres = genreService.listOfGenre();
        if(image != null && imageFileName.trim().length() > 0){
            String realPath = ServletActionContext.getServletContext().getRealPath("/menuImages");
            File imageFile = new File(new File(realPath),imageFileName);
            try {
                if(!imageFile.getParentFile().exists()){
                    imageFile.getParentFile().mkdir();
                }
                FileUtils.copyFile(image,imageFile);
            } catch (IOException e) {
                e.printStackTrace();
                this.addActionError(e.getMessage());
                return "EXCEPTIONS";
            }
            this.imageURL = imageFileName;
        }
        this.id = (Integer) ActionContext.getContext().getSession().get("menuId");
        ActionContext.getContext().getSession().remove("menuId");
        menuService.updateMenuInfo(this.id,this.genreId, this.name,this.imageURL,this.description,this.price);
        return SUCCESS;
    }

    public String topThree(){
        LikesService likesService = new LikesServiceImpl();
        List temp = likesService.getTotalScore();
        if(temp != null){
            this.listOfMenu = new ArrayList<Menu>();
            for(int i = 0; i<temp.size(); i++){
                this.listOfMenu.add((Menu)temp.get(i));
            }
            if(this.listOfMenu.size() < 3){
                MenuService menuService = new MenuServiceImpl();
                List<Menu> menusWithouScore = menuService.findThreeFoodsWithouScore();
                int size = listOfMenu.size();
                for(int i = 0; i < 3-size; i++){
                    if(i >= menusWithouScore.size() || menusWithouScore.size() < 3) break;
                    this.listOfMenu.add(menusWithouScore.get(i));
                }
            }
        }
        return SUCCESS;
    }

    public String findAllFoodsByGenre(){
        MenuService menuService = new MenuServiceImpl();
        this.listOfMenu = menuService.findAllFoodsByGenre(this.genreId);
        return SUCCESS;
    }

    public String redirectToUpdate(){
        ActionContext.getContext().getSession().put("menuId",id);
        ActionContext.getContext().getSession().put("menuName",name);
        return "redirected";
    }

    public String createLineItems(){
        LineItemService lineItemService = new LineItemServiceImpl();
        Map map = ActionContext.getContext().getSession();
        Integer orderId = (Integer)map.get("orderId");
        Integer menuId = (Integer) map.get("menuId");

        LineItem lineItem = new LineItem();
        lineItem.setQuantity(1);
        lineItemService.createLineItems(orderId, menuId, lineItem);
        map.remove("menuId");
        return SUCCESS;
    }

    public String findMenu(){
        MenuService menuService = new MenuServiceImpl();
        Menu menu = menuService.findMenu(this.id);
        this.setId(menu.getId());
        this.setImageURL(menu.getImageURL());
        this.setDescription(menu.getDescription());
        this.setName(menu.getName());
        this.setPrice(menu.getPrice());
        this.setAverage(menu.getAverage());
        return SUCCESS;
    }


    //TODO MARK...
    public String findGenresAndMenus(){
        GenreService genreService = new GenreServiceImpl();
        MenuService menuService = new MenuServiceImpl();
        LikesService likesService = new LikesServiceImpl();
        List listOfAverage = likesService.getAllAverageScore();
        List<Genre> listOfgenre = new ArrayList<Genre>();
        for(int i = 0; i < listOfAverage.size(); i++){
            List temp = (List) listOfAverage.get(i);
            Integer menuId = ((Menu)(temp.get(0))).getId();
            double avg = (Double) temp.get(1);
            float average = (float) avg;
            menuService.updateAverage(menuId,average);
        }
        this.genres = genreService.listOfGenre();
        Map map = ActionContext.getContext().getSession();
        String s = null;
        for(int i = 0; i < this.genres.size(); i++){
            s = String.valueOf(i);
            map.put("genreName_" + s, this.genres.get((i)).getName());
            map.put("genreId_" + s, String.valueOf(this.genres.get((i)).getId()));
        }
        String t = String.valueOf(this.genres.size());
        map.put("genre_size",t);
        if(this.genreId == null){
            this.genreId = this.genres.get(0).getId();
        }
        this.listOfMenu = menuService.findAllFoodsByGenre(this.genreId);
        this.genre = genreService.GenreById(this.genreId);
        map.put("genreName", this.genre.getName());
        return SUCCESS;
    }
}
