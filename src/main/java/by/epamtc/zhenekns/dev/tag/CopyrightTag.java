package by.epamtc.zhenekns.dev.tag;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CopyrightTag extends TagSupport {

    private final static Logger logger = LogManager.getLogger();
    private final static String COPYRIGHT = "©";
    private final static String stick = "-";

    private String year;
    private String developer;

    public void setYear(String year) {
        this.year = year;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public int doStartTag() throws JspException {
        String copyright = getCopyright();
        try {
            JspWriter out = pageContext.getOut();
            out.write(copyright);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    private String getCopyright() {
        StringBuilder value;
        value = new StringBuilder(COPYRIGHT);
        value.append(developer).append(" ").append(stick).append(" ").append(year);
        return value.toString();
    }
}
