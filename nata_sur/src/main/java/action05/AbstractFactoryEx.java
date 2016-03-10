package action05;

import java.util.Arrays;

public class AbstractFactoryEx {
	public static void main(String[] args) {
		//Application app = new Application(new FactoryRusBig());
		Application app = new Application(new FactoryEnglishSmall());
		
		app.menu.print();
		app.images.print();
	}

}
class Application{
	protected Component menu;
	protected Component images;
	public Application(AbstractFactoryApplication factory){
		menu = factory.createMenu();
		images = factory.createImages();
	}
}

interface AbstractFactoryApplication{
	public Component createMenu();
	public Component createImages();
}

class FactoryEnglishSmall implements AbstractFactoryApplication{
	@Override
	public AbstractMenu createMenu() {
		return new MenuEnglish();
	}
	@Override
	public AbstractImages createImages() {
		return new ImagesSmallEnglish();
	}	
}
class FactoryRusBig implements AbstractFactoryApplication{
	@Override
	public AbstractMenu createMenu() {
		return new MenuRus();
	}
	@Override
	public AbstractImages createImages() {
		return new ImagesBigRus();
	}	
}
/* Components: Menu and Images*/

interface Component{
	public void print();
	public String getName();
}
/* Menu Component */
abstract class AbstractMenu implements Component{
	private String name;
	private String[] menuItem = new String[]{};
	public AbstractMenu(String name){
		this.name = name;
	}
	public void setMenuList(String[] arr){
		menuItem = arr;
	}
	@Override
	public void print(){
		System.out.println(name+Arrays.toString(menuItem));
	}
	@Override
	public String getName(){
		return name;
	}
}
class MenuEnglish extends AbstractMenu{
	public MenuEnglish(){
		super("menu");
	}
}
class MenuRus extends AbstractMenu{
	public MenuRus(){
		super("меню");
	}
}

/* Images Component */
abstract class AbstractImages implements Component{
	private String name;
	public AbstractImages(String name){
		this.name = name;
	}
	@Override
	public void print(){
		System.out.println(name);
	}
	@Override
	public String getName(){
		return name;
	}
}
class ImagesBigEnlish extends AbstractImages{
	public ImagesBigEnlish(){
		super("english big images");
	}
}
class ImagesSmallEnglish extends AbstractImages{
	public ImagesSmallEnglish(){
		super("english small images");
	}
}

class ImagesBigRus extends AbstractImages{
	public ImagesBigRus(){
		super("рус большие картинки");
	}
}
class ImagesSmallRus extends AbstractImages{
	public ImagesSmallRus(){
		super("рус маленькие картинки");
	}
}