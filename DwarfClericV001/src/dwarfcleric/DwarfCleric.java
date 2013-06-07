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
	
	boolean closeRequested = false;

	public void startDisplay() {
		// This code came from lwjgl tutorial 1 (Display)
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		Mouse.setGrabbed(true);
		
		// initialize OpenGL here
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		
		
		while (!Display.isCloseRequested() && !closeRequested) {
			// render OpenGL here
			//Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f,0.5f,1.0f);
			
			// draw quad
//			GL11.glBegin(GL11.GL_QUADS);
//			GL11.glVertex2f(100, 100);
//			GL11.glVertex2f(100+200, 100);
//			GL11.glVertex2f(100+200, 100+200);
//			GL11.glVertex2f(100, 100+200);
//			GL11.glEnd();
			
			pollInput(); //I guess I don't need a this.pollInput() ?
			Display.update();
		}
		
		Display.destroy();
	}
	
	
	public void pollInput() {
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
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					System.out.println("Quitting!");
					this.closeRequested = true;
				}
			}
		}
		
		// draw quad
		int x = Mouse.getX();
		int y = Mouse.getY();
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x+200, y);
		GL11.glVertex2f(x+200, y+200);
		GL11.glVertex2f(x, y+200);
		GL11.glEnd();
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		
		DwarfCleric dc = new DwarfCleric();
		dc.startDisplay();
	}

}
