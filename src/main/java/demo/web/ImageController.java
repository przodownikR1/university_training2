package demo.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/photo")
@Api(value = "Image", description = "image API")
public class ImageController {
 
    @Autowired
    private org.springframework.core.io.Resource photo;
 
    
 
    @ApiOperation(httpMethod = "GET", value = "getPhoto")

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
    public byte[] getPhoto(@PathVariable("id") Integer photoId, Principal principal) throws IOException {
        byte[] content = null;
        content = photoToByte(photo);
        return content;
    }
 
    private byte[] photoToByte(org.springframework.core.io.Resource photo) throws IOException {
        byte content[] = new byte[(int) photo.contentLength()];
        photo.getInputStream().read(content);
        return content;
    }
 
}