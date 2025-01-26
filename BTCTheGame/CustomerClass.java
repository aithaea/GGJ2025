import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Write a description of class CustomerClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerClass
{
    String[] customers;
    String queueingCustomer, currentCustomer;
    ImageIcon queueingImage, currentImage;
    public CustomerClass() {
         queueingCustomer = pickRandomCustomer();
         currentCustomer = pickRandomCustomer();
    }
    public String pickRandomCustomer() {
        String[] customers = {"Kevin","Dave","Gloria"} ;
        int random = (int)(Math.random()*3);
        return customers[random];
    }
    public ImageIcon[] incrementCustomers() {
        currentCustomer = queueingCustomer;
        queueingCustomer = pickRandomCustomer();
        return customerImages();
    }
    public ImageIcon[] customerImages() {
        
        if (currentCustomer.equals("Kevin")) {
            currentImage = resizeImages("KevinForward.png");
        } else if (currentCustomer.equals("Dave") ) {
            currentImage = resizeImages("DaveForward.png");
        } else {
            currentImage = resizeImages("GloriaForward.png");
        }
        
        if (queueingCustomer.equals("Kevin")) {
            queueingImage = resizeImages("KevinLeft.png");
        } else if (queueingCustomer.equals("Dave") ) {
            queueingImage = resizeImages("DaveLeft.png");
        } else {
            queueingImage = resizeImages("GloriaLeft.png");
        }
        
        ImageIcon[] images = {queueingImage, currentImage};
        return images;
    }
    public ImageIcon resizeImages(String s) {
        ImageIcon imageIcon = new ImageIcon("Images/" + s); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    
    
}
