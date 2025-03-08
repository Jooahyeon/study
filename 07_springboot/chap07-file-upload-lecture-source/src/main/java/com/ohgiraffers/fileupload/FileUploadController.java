package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class FileUploadController {

    @Value("${filepath}")
    private String filePath;

    /* 설명. multi-part/form-data로 넘어오는 값은 MultipartFile로 받아내야 한다.*/
    @PostMapping("single-file")
    public String singleFile(@RequestParam MultipartFile singleFile,
                             @RequestParam String singleFileDescription,
                             RedirectAttributes rttr) {
//        System.out.println("singleFile = " + singlefile);
//        System.out.println("singleFileDescription = " + singleFileDescription);

        /* 설명. 1. 저장될 파일의 경로 설정 후 파일 저장*/
        /* 설명. 2. 파일의 이름 리네임 */
        /* 설명. 3. DB로 보낼 데이터 만들기(List<Map<String, String>>) */
        //경로설정
//        String filePath = "/Users/AHyeon/Documents/uploadFiles";

        // file:///Users/AHyeon/Documents/uploadFiles

        /* 설명. 사용자가 넘긴 파일의 원본이름을 확이하고 rename해보자
        *   (자바 UUID 클래스를 이용한 무작위 문자열 형태로 생성) */

        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);

        String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 마지막 점의 위치 인덱스를 넘김(확장자 위치)
        System.out.println("ext = " + ext);

        // UUID.randomUUID().toString(). 비밀번호 찾기(이 비밀번호 치고 들어오라 날라오는 메일 설정할 때 이거 사용함)
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);

        /* 설명. 우리가 지정한 경로로 파일을 저장 */
        try {
            singleFile.transferTo(new File(filePath +  "/img/single" + savedName)); // 파일 저장
            // -> 성공한 값은 DB로(어떤 회원이 어떤 파일을 저장했는지 한 행으로 디비에 저장을 해줘야 함)

            /* 설명. DB로 보낼 데이터 Map으로 가공 처리 */
            // 성공했다면
            Map<String, String> file = new HashMap<>();
            file.put("originFileName", originFileName);
            file.put("savedName", savedName);
            file.put("filePath", "/img/single");
            file.put("singleFileDescription", singleFileDescription);

            /* 설명. 이후 Service 계층을 통해 DB에 사용자가 업로드 한 파일의 내용을 저장하고 옴(지금 작성할 내용은 아님-> 프로젝트때는 해야 함) */
            // 서비스 계층에서 현재 회원의 아이디 정보 뽑고 게시물 (파일) 확인하여 정보 추출하여 디비에 저장
//            fileUploadService.registFile(file);


            // 파일 업로드 성공여부 확인
            rttr.addFlashAttribute("message", originFileName + "파일업로드 성공!");
            rttr.addFlashAttribute("img", "/img/single/" + savedName);
            // / -> yml에 설정한 경로를 뜻함

            rttr.addFlashAttribute("singleFileDescription", singleFileDescription);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/result";
    }

    @PostMapping("multi-file")
        public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
                                      @RequestParam String multiFileDescription,
                                      RedirectAttributes rttr) {
//                String filePath = "/Users/AHyeon/Documents/uploadFiles";

                /* 설명. DB에 보낼 값을 담기 위한 컬렉션 */
                List<Map<String, String>> files = new ArrayList<>();

                /* 설명. 화면에서 각 파일마다 img태그의 src 속성으로 적용하기 위한 문자열을 담은 컬렉션 */
                List<String>imgSrcs = new ArrayList<>();

//        List<Map<String, String>> file = new ArrayList<>();

        try {
            for (int i = 0; i < multiFiles.size(); i++) {

                /* 설명. 각 파일마다 리네임 */
                String originFileName = multiFiles.get(i).getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("=", "") + ext;

                /* 설명. 파일 저장 경로에 저장 */
                multiFiles.get(i).transferTo(new File(filePath + "/img/multi/" + savedName));

                /* 설명. DB에 보내 값 설정(Map<String, String>)*/
                Map<String, String> file = new HashMap<>();
                file.put("originFileName", originFileName);
                file.put("savedName", savedName);
                file.put("filePath", "/img/multi");
                file.put("multiFileDescription", multiFileDescription);

                files.add(file);
                imgSrcs.add("img/multi/" + savedName);
            }   // For end

            /* 설명. singleFile 업로드 때와 마찬가지로 DBf를 다녀옴(지금 작성할 내용은 아님)*/
//            fileUploadService.registFile(files);

            /* 설명. 여기까지 성공했다면 파일 저장 및 DB insert까지 모두 완성되었으니 화면의 재료 작성 */
            rttr.addFlashAttribute("message", "다중 파일 업로드 성공!");
            rttr.addFlashAttribute("imgs", imgSrcs);
            rttr.addFlashAttribute("multiFileDescription", multiFileDescription);


        } catch (IOException e) {

            /* 설명. transferTo로 파일을 경로에 저장하다가 예외가 발생하면 앞에 이미 성공해서 저장된 파일들을 찾아 지움 */
            for (int i = 0; i < files.size() - 1; i++) {
                Map<String, String> file = files.get(i);
                new File(filePath + "/img/multi/" + file.get("savedName")).delete();
            }

            rttr.addFlashAttribute("message", "파일 업로드 실패");

        }

        return "redirect:/result";

        }


    @GetMapping("result")
    public void result() {
    }
}
