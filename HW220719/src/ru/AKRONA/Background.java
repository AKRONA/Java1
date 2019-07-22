package ru.AKRONA;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Background {
    private String time;
    private Color color;

    protected void setColor(GameCanvas canvas){
        time = new SimpleDateFormat("hhmmss").format(Calendar.getInstance().getTime());
        color = new Color((int)Math.round((Integer.parseInt(time)/100%100)*4.32),Integer.parseInt(time)/10000*11,(int)Math.round((Integer.parseInt(time)%100)*4.32));
        canvas.setBackground(color);
    }
}
