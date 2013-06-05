package dwarfcleric;

import static org.lwjgl.opengl.GL11.GL_POLYGON;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glFlush;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLU.*;

import java.awt.Font;
import java.io.InputStream;
import java.nio.FloatBuffer;

import java.util.*;
import org.lwjgl.util.glu.Sphere;

public class DwarfCleric {

	public void startDisplay() {
		// This code came from lwjgl tutorial 1 (Display)
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// initialize OpenGL here
		while (!Display.isCloseRequested()) {
			// render OpenGL here
			
			pollInput(); //I guess I don't need a this.pollInput() ?
			Display.update();
		}
		
		Display.destroy();
	}
	
	
	public void pollInput() {
		//Check the mouse button down
//		if (Mouse.isButtonDown(0)) {
//			int x = Mouse.getX();
//			int y = Mouse.getY();
//			
//			System.out.println("Mouse was left clicked at X: " + x + " Y: " + y);
//		}
		
		//Doing it this way ensures that we only get one event per click
		while (Mouse.next()) {
			if (Mouse.getEventButtonState()) {
				if (Mouse.getEventButton() == 0) {
					System.out.println("CLICKED: LEFT");
				}
			}
		}
		
		//Check the keyboard
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					System.out.println("PRESSED: A");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		
		DwarfCleric dc = new DwarfCleric();
		dc.startDisplay();
	}

}
