package fh.love.cyh.codegenerationtools.local;

import fh.love.cyh.codegenerationtools.domain.Page;
import fh.love.cyh.codegenerationtools.support.TableSupport;

public class LocalVariable {
    public static final ThreadLocal<Page> LOCAL_PAGE = new ThreadLocal<>();

    public static void setLocalPage(Page page){
        LOCAL_PAGE.set(page);
    }

    public static Page getLocalPage(){
        if(LOCAL_PAGE.get() == null){
            LOCAL_PAGE.set(TableSupport.convert());
        }
        return LOCAL_PAGE.get();
    }
}
