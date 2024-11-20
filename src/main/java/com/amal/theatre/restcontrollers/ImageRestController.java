package com.amal.theatre.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.amal.theatre.entities.Image;
import com.amal.theatre.entities.Pieceth;
import com.amal.theatre.service.ImageService;
import com.amal.theatre.service.PiecethService;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

	@Autowired
	ImageService imageService;

	@Autowired
	PiecethService piecethService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImagePiece/{idPiece}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idPiece") Long idPiece)
			throws IOException {
		return imageService.uplaodImagePiece(file, idPiece);
	}

	@RequestMapping(value = "/getImagesPiece/{idPiece}", method = RequestMethod.GET)
	public List<Image> getImagesPiece(@PathVariable("idPiece") Long idPiece) throws IOException {
		return imageService.getImagesParPiece(idPiece);
	}

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Pieceth p = piecethService.getPieceth(id);
		p.setImagePath(id + ".jpg");

		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + p.getImagePath()), file.getBytes());
		piecethService.savePieceth(p);

	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		Pieceth p = piecethService.getPieceth(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + p.getImagePath()));
	}

}
