/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;
import com.example.demo.Entity.Banner;
import com.example.demo.Service.BannerService;
import com.example.demo.dto.DtoBanner;
import com.example.demo.security.controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yuli
 */

@RestController
@RequestMapping("banner")
@CrossOrigin(origins = "https://portfolio-yuliana.web.app/")
public class BannerController {

    @Autowired BannerService bannerService;

    @GetMapping("/list")
    public ResponseEntity<List<Banner>> getBanner(){

        return new ResponseEntity<>(bannerService.getBanner(), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?>createBanner(@RequestBody DtoBanner dtoBanner){

        Banner banner = new Banner(dtoBanner.getImgBanner());

        bannerService.saveBanner(banner);

        return new ResponseEntity<>(new Mensaje("Banner creado"), HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable("id") Long id, @RequestBody DtoBanner dtoBanner){


       Banner banner = bannerService.getOne(id).get();
      banner.setImgBanner(dtoBanner.getImgBanner());
      bannerService.saveBanner(banner);
        return new ResponseEntity(new Mensaje("Banner actualizado"), HttpStatus.OK);
    }



}

