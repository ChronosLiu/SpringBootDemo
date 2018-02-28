package cn.yang.bootdemo.domain;

/**
 * @Author: liuyang
 * @Description:
 * @Date: Created in 18:07 2018/2/28
 */

public class Msg {
    private String title;
    private String content;
    private String etraInfo;

    public Msg(){
        super();
    }

    public Msg(String title,String content,String etraInfo){
        super();
        this.content = content;
        this.title = title;
        this.etraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
