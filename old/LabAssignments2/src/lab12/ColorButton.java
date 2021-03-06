package lab12;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorButton extends JButton
{

	String button_name;
	Color draw_color;
	Dimension button_size;
	
	public ColorButton(String button_01, Color draw_color, Dimension xy) 
	{
		super(button_01);
		this.button_name = button_01;
		this.draw_color = draw_color;
		button_size = new Dimension(xy);
	}

	public String getButton_01() 
	{
		return button_name;
	}

	public Color getDraw_color() 
	{
		return draw_color;
	}

	public Dimension getButton_size() 
	{
		return button_size.getSize();
	}
	


	
	
	
}
