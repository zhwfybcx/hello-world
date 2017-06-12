<@pp.dropOutputFile />
<#list dalgen.pagings as paging>
    <@pp.changeOutputFile name = "/main/java/${paging.baseClassPath}/BasePage.java" />
package ${paging.basePackageName};

import java.util.List;

/**
 * 用于分页的工具类
 */
public class BasePage<T> {

    private List<T> datas;                  //对象记录结果�?    private int     total           = 0;    // 总记录数
    private int     limit           = 20;   // 默认每页显示记录�?    private int     pageNos         = 1;    // 总页�?    private int     currPageNo      = 1;    // 当前�?
    private boolean isFirstPage     = false; //是否为第�?��
    private boolean isLastPage      = false; //是否为最后一�?    private boolean hasPreviousPage = false; //是否有前�?��
    private boolean hasNextPage     = false; //是否有下�?��

    private int     navigatePages   = 8;    //导航页码�?    private int[]   navigatePageNos;        //�?��导航页号

    private void init() {
        this.pageNos = (this.total - 1) / this.limit + 1;

        //根据输入可能错误的当前号码进行自动纠�?        if (currPageNo < 1) {
            this.currPageNo = 1;
        } else if (currPageNo > this.pageNos) {
            this.currPageNo = this.pageNos;
        } else {
            this.currPageNo = currPageNo;
        }

        //基本参数设定之后进行导航页面的计�?        calcNavigatePageNumbers();

        //以及页面边界的判�?        judgePageBoudary();
    }

    /**
     * 计算导航�?     */
    private void calcNavigatePageNumbers() {
        //当�?页数小于或等于导航页码数�?        if (pageNos <= navigatePages) {
            navigatePageNos = new int[pageNos];
            for (int i = 0; i < pageNos; i++) {
                navigatePageNos[i] = i + 1;
            }
        } else { //当�?页数大于导航页码数时
            navigatePageNos = new int[navigatePages];
            int startNum = currPageNo - navigatePages / 2;
            int endNum = currPageNo + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(�?��navigatePages�?                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNos[i] = startNum++;
                }
            } else if (endNum > pageNos) {
                endNum = pageNos;
                //�?��navigatePages�?                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatePageNos[i] = endNum--;
                }
            } else {
                //�?��中间�?                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNos[i] = startNum++;
                }
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = currPageNo == 1;
        isLastPage = currPageNo == pageNos && currPageNo != 1;
        hasPreviousPage = currPageNo > 1;
        hasNextPage = currPageNo < pageNos;
    }

    /**
     * 得到数据
     * 
     * @return
     */
    public List<T> getDatas() {
        return datas;
    }

    /**
     * 设置数据
     * 
     * @param datas
     */
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 得到记录总数
     *
     * @return {int}
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置总记录数
     * 
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
        init();
    }

    /**
     * 得到每页显示多少条记�?     *
     * @return {int}
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置每页多少记录
     * 
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * 设置导航线上几页
     * 
     * @param navigatePages
     */
    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    /**
     * 得到页面总数
     *
     * @return {int}
     */
    public int getPageNos() {
        return pageNos;
    }

    /**
     * 得到当前页号
     *
     * @return {int}
     */
    public int getCurrPageNo() {
        return currPageNo;
    }

    /**
     * 得到�?��导航页号
     *
     * @return {int[]}
     */
    public int[] getNavigatePageNos() {
        return navigatePageNos;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public boolean hasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean hasNextPage() {
        return hasNextPage;
    }

    /**
     * 设置当前�?     * @param currPageNo
     */
    public void setCurrPageNo(int currPageNo){
        if(currPageNo==0){
            this.currPageNo =1;
        }else {
            this.currPageNo = currPageNo;
        }
    }

    /**
    * 得到�?���?    */
    public int getStartRow(){
        return (this.currPageNo-1)*this.limit;
    }

                public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[").append("total=").append(total).append(",pageNos=").append(pageNos)
                .append(",currPageNo=").append(currPageNo).append(",limit=").append(limit)
                .append(",isFirstPage=").append(isFirstPage).append(",isLastPage=")
                .append(isLastPage).append(",hasPreviousPage=").append(hasPreviousPage)
                .append(",hasNextPage=").append(hasNextPage).append(",navigatePageNos=");
        int len = navigatePageNos.length;
        if (len > 0)
            sb.append(navigatePageNos[0]);
        for (int i = 1; i < len; i++) {
            sb.append(" " + navigatePageNos[i]);
        }
        sb.append(",datas.size=" + datas.size());
        sb.append("]");
        return sb.toString();
    }
}
</#list>
