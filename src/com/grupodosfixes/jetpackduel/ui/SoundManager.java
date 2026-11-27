package com.grupodosfixes.jetpackduel.ui;

import javax.sound.sampled.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {

    private Clip music;

    private Map<String, Clip> sounds = new HashMap<>();


    private Clip loadClip(String path) {
        URL url = getClass().getResource(path);
        if (url == null) {
            System.out.println("Sound not found: " + path);
            return null;
        }

    try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            return clip;
        } catch (Exception e) {
            System.out.println("Could not load sound: " + path);
            return null;
        }

    }

    public SoundManager() {
        loadEffect("armor_power_up_player");
        loadEffect("boulder_hit_opponent");
        loadEffect("bullet_firing_player");
        loadEffect("flame_hit_player_opponent");
        loadEffect("health_heart");
        loadEffect("ice_ball_hit");
        loadEffect("jetpack");
        loadEffect("lightning_opponent");
        loadEffect("menu_click_sound");
        loadEffect("obstacle_throwing");
        loadEffect("player_hit");
        loadEffect("enemy_hit");

    }

    private void loadEffect(String name) {
        sounds.put(name, loadClip("/sounds/effects/" + name + ".wav"));
    }

    public void playEffect(String name) {
        Clip clip = sounds.get(name);
        if (clip == null) {
            return;
        }
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public void loopEffect(String name) {
        Clip clip = sounds.get(name);
        if (clip == null || clip.isRunning()) {
            return;
        }
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopEffect(String name) {
        Clip clip = sounds.get(name);
        if (clip != null) {
            clip.stop();
        }
    }
    public void playMusic(String fileName, double loopStartSeconds) {
        stopMusic();
        music = loadClip("/sounds/music/" + fileName + ".wav");
        if (music == null) {
            return;
        }
        int startFrame = (int) (loopStartSeconds * music.getFormat().getFrameRate());
        music.setLoopPoints(startFrame, -1);
        music.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopMusic() {
        if (music != null) {
            music.stop();
            music.close();
            music = null;
        }
    }

    public void stopAll() {
        stopMusic();
        for (Clip clip : sounds.values()) {
            if (clip != null) {
                clip.stop();
            }
        }
    }
}
