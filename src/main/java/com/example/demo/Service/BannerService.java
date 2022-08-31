/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;
import com.example.demo.Entity.Banner;
import com.example.demo.Repository.BannerRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yuli
 */

@Service
@Transactional
public class BannerService {

    @Autowired BannerRepository bannerRepository;

     public List<Banner> getBanner() {
       List<Banner> banner= bannerRepository.findAll();
       return banner;
    }

    public void saveBanner(Banner banner) {
     bannerRepository.save(banner);
    }

    public void deleteBanner(Long id) {
     bannerRepository.deleteById(id);
    }


    public Banner findBanner(Long id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        return banner;
    }

       public Optional<Banner> getOne(Long id){

        return bannerRepository.findById(id);
    }

}

/**
 *
 * @author Yuli
 */
