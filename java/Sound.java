/*
Borrowed from edu4java.com
6/30/18
*/

package com.edu4java.minitennis7;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("game.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}
