/*
 * Enum FontSelector
 *
 * Responsável por fornecer fontes para a interface gráfica
 *
 * Atributos:
 * - fontName
 * - fontPath
 *
 * Métodos:
 * getFontName()
 * getFontPath()
 * getFont()
 *
 */
package projetomc322.font;

import java.awt.Font;
import java.io.File;

public enum FontSelector {
    ROBOTO_BLACK("Roboto Black", "src/projetomc322/font/Roboto-Black.ttf"),
    ROBOTO_BLACK_ITALIC("Roboto Black Italic", "src/projetomc322/font/Roboto-BlackItalic.ttf"),
    ROBOTO_BOLD("Roboto Bold", "src/projetomc322/font/Roboto-Bold.ttf"),
    ROBOTO_BOLD_ITALIC("Roboto Bold Italic", "src/projetomc322/font/Roboto-BoldItalic.ttf"),
    ROBOTO_ITALIC("Roboto Italic", "src/projetomc322/font/Roboto-Italic.ttf"),
    ROBOTO_LIGHT("Roboto Light", "src/projetomc322/font/Roboto-Light.ttf"),
    ROBOTO_LIGHT_ITALIC("Roboto Light Italic", "src/projetomc322/font/Roboto-LightItalic.ttf"),
    ROBOTO_MEDIUM("Roboto Medium", "src/projetomc322/font/Roboto-Medium.ttf"),
    ROBOTO_MEDIUM_ITALIC("Roboto Medium Italic", "src/projetomc322/font/Roboto-MediumItalic.ttf"),
    ROBOTO_REGULAR("Roboto Regular", "src/projetomc322/font/Roboto-Regular.ttf"),
    ROBOTO_THIN("Roboto Thin", "src/projetomc322/font/Roboto-Thin.ttf"),
    ROBOTO_THIN_ITALIC("Roboto Thin Italic", "src/projetomc322/font/Roboto-ThinItalic.ttf");

    private String fontName;
    private String fontPath;

    FontSelector(String fontName, String fontPath) {
        this.fontName = fontName;
        this.fontPath = fontPath;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getFontName() {
        return this.fontName;
    }
    
    public Font getFont() {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(this.fontPath));
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
