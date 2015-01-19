package com.hasherr.stegory.ui.controllers;

import com.hasherr.stegory.ui.controllers.tools.ImageDetails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Evan on 1/19/2015.
 */
public class SelectCarrierImageButtonController extends ComponentController implements ImageDetails
{
    private String filePath;
    private int width, height;
    private boolean isFileSelected;

    @Override
    public void actionPerformed(ActionEvent event)
    {
        isFileSelected = true;
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION)
        {
            File carrierFile = fileChooser.getSelectedFile();
            filePath = carrierFile.getAbsolutePath();

            try
            {
                BufferedImage carrier = ImageIO.read(carrierFile);
                width = carrier.getWidth();
                height = carrier.getHeight();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String getFilePath()
    {
        return filePath;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    @Override
    public boolean getIsFileSelected()
    {
        return isFileSelected;
    }

    @Override
    public void setIsFileSelected(boolean isFileSelected)
    {
        this.isFileSelected = isFileSelected;
    }
}
