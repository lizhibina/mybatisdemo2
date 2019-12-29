package com.rails.mybatisdemo.demo.api;/**
 * @Auther: lizhibin
 * @Date: 2019/5/27 15:41
 * @Description:
 */

import com.rails.mybatisdemo.demo.utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: project
 *
 * @description:
 *
 * @author: Lizhibin
 *
 * @create: 2019/05/27 15:41
 **/

@Api(tags = { "文件上传" })
@Validated
@RestController
@RequestMapping("uploadFile")
public class UploadFileApi {
    //跳转到上传文件的页面
    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @ApiOperation(value = "文件上传")
    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(/*@RequestParam("file")*/ MultipartFile file,
                                          HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String filePath = "D:/";
        try {
            CommonUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }

}


