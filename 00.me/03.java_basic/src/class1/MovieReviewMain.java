package class1;

public class MovieReviewMain {
    public static void main(String[] args) {
        // 영화 리뷰 정보 선언
        MovieReview inception = new MovieReview();
        // 영화 리뷰 정보 출력
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화!";

        System.out.println("영화제목: " + inception.title + ", 리뷰: " + inception.review);
        System.out.println("영화제목: " + aboutTime.title + ", 리뷰: " + aboutTime.review);



    }
}
