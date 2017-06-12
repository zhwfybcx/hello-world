package com.zwf.cms.web.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/**
 * 分页器
 *
 * @author Herbert
 *
 * @param <T>
 */
public class PageVo<T> implements Serializable {
    /**  */
    private static final long serialVersionUID = 8722393576023511459L;
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 页码总数
     */
    private int pageCount;
    /**
     * 总数
     */
    private long count;
    /**
     * 偏移
     */
    private int offset;
    /**
     * 数量
     */
    private int rows;
    /**
     * 数据
     */
    private List<T> list;
    /**
     * 页码HTML
     */
    private String pageNumHtml;
    private String frontPageNumHtml;
    /**
     * 参数
     */
    private Map<String, String> args = new HashMap<String, String>();

    public PageVo(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        if (this.pageNum <= 0) {
            this.pageNum = 1;
            return 1;
        } else {
            return pageNum;
        }
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        this.pageCount = (int) (((this.getCount() - 1) / this.getRows()) + 1);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getOffset() {
        this.offset = (this.getPageNum() - 1) * this.getRows();
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getUrl(int num) {
        Iterator<Entry<String, String>> iter = this.getArgs().entrySet().iterator();
        List<String> values = new ArrayList<String>();
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            values.add(key + "=" + val);
        }
        values.add("p=" + num);
        return "?" + StringUtils.join(values.toArray(), "&");
    }

    public void setPageNumHtml(String pageNumHtml) {
        this.pageNumHtml = pageNumHtml;
    }

    public String getPageNumHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<ul class=\"pagination\">");
        // 首页，上一页
        if (this.getPageNum() != 1) {
            sb.append("<li><a href='" + this.getUrl(1) + "' title='首页'>&lt;&lt;</a></li>");
            sb.append("<li><a href='" + this.getUrl(this.getPageNum() - 1) + "' title='上一页'>&lt;</a></li>");
        }
        // 页码
        if (this.getPageCount() != 1) {
            int startNum = this.getPageNum() - 3 <= 1 ? 1 : this.getPageNum() - 3;
            int endNum = this.getPageNum() + 3 >= this.getPageCount() ? this.getPageCount() : this.getPageNum() + 3;
            if (startNum > 1) {
                sb.append("<li><a href='javascript:void(0);'>...</a></li>");
            }
            for (int i = startNum; i <= endNum; i++) {
                if (i == pageNum) {
                    sb.append("<li class='active'><a   href='" + this.getUrl(i) + "' class='number current' title='" + i + "'>" + i + "</a></li>");
                } else {
                    sb.append("<li><a href='" + this.getUrl(i) + "' class='number' title='" + i + "'>" + i + "</a></li>");
                }
            }
            if (endNum < this.getPageCount()) {
                sb.append("<li><a href='javascript:void(0);'>...</a></li>");
            }
        }
        // 下一页，尾页
        if (this.getPageNum() < this.getPageCount()) {
            sb.append("<li><a href='" + this.getUrl(this.getPageNum() + 1) + "' title='下一页'>&gt;</a></li>");
            sb.append("<li><a href='" + this.getUrl(this.getPageCount()) + "' title='末页'>&gt;&gt;</a></li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    /**
     * 前端分页条
     *
     * @return
     */
    public String getFrontPageNumHtml() {
        Iterator<Entry<String, String>> iter = this.getArgs().entrySet().iterator();
        String folderId = "/article/";
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            if(StringUtils.equalsIgnoreCase("folderId", entry.getKey())){
                folderId += entry.getValue()+"/";
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<div class=\"sPaegs\">");
        // 首页，上一页
        if (this.getPageNum() != 1) {
            sb.append("<a href='" + folderId+(this.getPageNum() - 1) + "' title='上一页' class=\"prev\"><i class=\"iconfont\">&#xe61d;</i></a>");
            if (this.getPageNum() > 4) {
                sb.append("<a href='" + folderId+ "1' title='首页'>1</a>");
            }
        }else{
            sb.append("<a href=\"javascript:;\" class=\"prev noAllow\"><i class=\"iconfont\">&#xe61d;</i></a>");
        }

        // 页码
        int endNum = this.getPageNum() + 3 >= this.getPageCount() ? this.getPageCount() : this.getPageNum() + 3;
        if (this.getPageCount() != 1) {
            int startNum = this.getPageNum() - 3 <= 1 ? 1 : this.getPageNum() - 3;

            if (startNum > 1+1) {//1+1这种写法更易懂
                sb.append("<span>...</span>");
            }
            for (int i = startNum; i <= endNum; i++) {
                if (i == pageNum) {
                    sb.append("<a class='active' href='" + folderId+i + "' title='" + i + "'>" + i + "</a>");
                } else {
                    sb.append("<a href='" + folderId+i + "' class='number' title='" + i + "'>" + i + "</a>");
                }
            }
            if (endNum < this.getPageCount() - 1) {
                sb.append("<span>...</span>");
            }
        }
        // 下一页，尾页
        if (this.getPageNum() < this.getPageCount()) {
            if(endNum != this.getPageCount()){
                sb.append("<a href='" + folderId+this.getPageCount() + "' title='末页'>"+getPageCount()+"</a>");
            }
            sb.append("<a href='" + folderId +(this.getPageNum() + 1) + "' title='下一页' class=\"next\"><i class=\"iconfont\">&#xe60d;</i></a>");
        }else{
            sb.append("<a href=\"javascript:;\" class=\"prev noAllow\"><i class=\"iconfont\">&#xe60d;</i></a>");
        }
        sb.append("</div>");
        return sb.toString();
    }

    /**
     * 前端分页条
     *
     * @return
     */
    public String getResourcePageNumHtml() {
        Iterator<Entry<String, String>> iter = this.getArgs().entrySet().iterator();
        String hrefStr = "resource?p=";
		/*while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			if(StringUtil.equalsIgnoreCase("p", entry.getKey())){
				hrefStr += "?p=" + entry.getValue();
			}
		}*/

        StringBuffer sb = new StringBuffer();
        sb.append("<div class=\"sPaegs\">");
        // 首页，上一页
        if (this.getPageNum() != 1) {
            sb.append("<a href='" + hrefStr+(this.getPageNum() - 1) + "' title='上一页' class=\"prev\"><i class=\"iconfont\">&#xe61d;</i></a>");
            if (this.getPageNum() > 4) {
                sb.append("<a href='" + hrefStr+ "1' title='首页'>1</a>");
            }
        }else{
            sb.append("<a href=\"javascript:;\" class=\"prev noAllow\"><i class=\"iconfont\">&#xe61d;</i></a>");
        }

        // 页码
        int endNum = this.getPageNum() + 3 >= this.getPageCount() ? this.getPageCount() : this.getPageNum() + 3;
        if (this.getPageCount() != 1) {
            int startNum = this.getPageNum() - 3 <= 1 ? 1 : this.getPageNum() - 3;

            if (startNum > 1+1) {//1+1这种写法更易懂
                sb.append("<span>...</span>");
            }
            for (int i = startNum; i <= endNum; i++) {
                if (i == pageNum) {
                    sb.append("<a class='active' href='" + hrefStr+i + "' title='" + i + "'>" + i + "</a>");
                } else {
                    sb.append("<a href='" + hrefStr+i + "' class='number' title='" + i + "'>" + i + "</a>");
                }
            }
            if (endNum < this.getPageCount() - 1) {
                sb.append("<span>...</span>");
            }
        }
        // 下一页，尾页
        if (this.getPageNum() < this.getPageCount()) {
            if(endNum != this.getPageCount()){
                sb.append("<a href='" + hrefStr+this.getPageCount() + "' title='末页'>"+getPageCount()+"</a>");
            }
            sb.append("<a href='" + hrefStr +(this.getPageNum() + 1) + "' title='下一页' class=\"next\"><i class=\"iconfont\">&#xe60d;</i></a>");
        }else{
            sb.append("<a href=\"javascript:;\" class=\"prev noAllow\"><i class=\"iconfont\">&#xe60d;</i></a>");
        }
        sb.append("</div>");
        return sb.toString();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
