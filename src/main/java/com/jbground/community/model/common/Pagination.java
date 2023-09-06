package com.jbground.community.model.common;

public class Pagination {

    private final int total;  //총 게시물 수
    private final int rowSize;   //한 화면에 보여질 게시물 수
    private final int pageSize;  //한 화면에 보여질 페이지 버튼 수
    private int currentPage;    //현재 페이지
    private int startPage = 1;  //한 화면에 보여질 페이지 버튼 시작
    private int endPage = 1;    //한 화면에 보여질 페이지 버튼 마지막
    private int firstPage = 1;  //첫 페이지, 첫 페이지는 항상 1
    private int lastPage = 1;   //마지막 페이지, totalPage 개수와 동일
    private int prevPage = 1;   //이전 페이지 그룹
    private int nextPage = 1;   //다음 페이지 그룹
    public static final int defaultRowSize = 10;
    public static final int defaultPageSize = 10;

    public Pagination(int total, int currentPage, int rowSize, int pageSize) {
        this.total = total;
        this.currentPage = currentPage;
        this.rowSize = rowSize;
        this.pageSize = pageSize;
        if(total != 0)
            this.paging();
    }
    private void paging() {
        firstPage = 1;
        lastPage = (total+rowSize-1)/rowSize ;

        currentPage = Math.min(currentPage, lastPage);

        startPage = ((currentPage-1)/pageSize) * pageSize + 1;
        endPage = Math.min(startPage + (pageSize - 1), lastPage);

        prevPage = Math.max(startPage - pageSize, 1);
        nextPage = Math.min(endPage + 1, lastPage);
    }

    public int getTotal() {
        return total;
    }
    public int getRowSize() {
        return rowSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pagination{");
        sb.append("total=").append(total);
        sb.append(", firstPage=").append(firstPage);
        sb.append(", prev=").append(prevPage);
        sb.append(", startPage=").append(startPage);
        sb.append(", currentPage=").append(currentPage);
        sb.append(", endPage=").append(endPage);
        sb.append(", next=").append(nextPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append('}');
        return sb.toString();
    }
}
