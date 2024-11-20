package com.amal.theatre.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.amal.theatre.entities.Image;

public interface ImageService {
	
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 Image uplaodImagePiece(MultipartFile file,Long idPiece) throws IOException;
	 List<Image> getImagesParPiece(Long pieceId);

}
