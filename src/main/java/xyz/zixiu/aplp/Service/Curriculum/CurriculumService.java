package xyz.zixiu.aplp.Service.Curriculum;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import xyz.zixiu.aplp.Pojo.Curriculum.CurriculumListPojo;
import xyz.zixiu.aplp.Pojo.Curriculum.CurriculumPojo;
import xyz.zixiu.aplp.Pojo.Curriculum.Part;
import xyz.zixiu.aplp.Pojo.School.UnitPojo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CurriculumService {
    RestTemplate restTemplate = new RestTemplate();

    public Boolean addCurriculum(MultipartFile file, CurriculumPojo newCurriculumPojo)throws IOException{
        System.out.println(newCurriculumPojo.toString());

        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }

            @Override
            public long contentLength() {
                return file.getSize();
            }
        };

        MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
        multipartRequest.add("multipartFile", fileAsResource);



        multipartRequest.add("curriculumId", newCurriculumPojo.getCurriculumId());
        multipartRequest.add("curriculumName",newCurriculumPojo.getCurriculumName());
        multipartRequest.add("describeText",newCurriculumPojo.getDescribeText());
        multipartRequest.add("coverPhotoUrl",newCurriculumPojo.getCoverPhotoUrl());




        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(multipartRequest, headers);

        return restTemplate.postForObject(UrlConstants.CURRICULUM_ADD,requestEntity,Boolean.class);
    }

    public CurriculumListPojo getCurriculumList(List<String> curriculumIdList){

        return restTemplate.postForObject(UrlConstants.CURRICULUM_LIST_GET,curriculumIdList,CurriculumListPojo.class);

    }

    public String addPart(String curriculumId,String partId,String themeText,String describeText){

        RestTemplate stringRestTemplate = new RestTemplate();
        stringRestTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        String addPartString="";
        addPartString+=curriculumId+"_";
        addPartString+=partId+"_";
        addPartString+=themeText+"_";
        addPartString+=describeText;


        System.out.println(addPartString);
        return stringRestTemplate.postForObject(UrlConstants.CURRICULUM_PART_ADD,addPartString,String.class);

    }

    public String addPartFile(MultipartFile file,String fileName,String CurriculumId,String partId) throws IOException {

        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }

            @Override
            public long contentLength() {
                return file.getSize();
            }
        };

        MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
        multipartRequest.add("multipartFile", fileAsResource);
        multipartRequest.add("fileName",fileName);
        multipartRequest.add("CurriculumId",CurriculumId);
        multipartRequest.add("partId",partId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(multipartRequest, headers);

        return restTemplate.postForObject(UrlConstants.CURRICULUM_PART_FILE_ADD,requestEntity,String.class);
    }

}