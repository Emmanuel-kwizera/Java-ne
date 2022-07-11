package com.example.techwebsite.serviceImpl;

import com.example.techwebsite.dtos.CreateWebsite;
import com.example.techwebsite.dtos.UpdateWebsite;
import com.example.techwebsite.exceptions.WebsiteNotFoundException;
import com.example.techwebsite.models.Website;
import com.example.techwebsite.repositories.WebsiteRepository;
import com.example.techwebsite.services.WebsiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WebsiteServiceImpl implements WebsiteServices {

  @Autowired
  private WebsiteRepository websiteRepository;
  @Override
  public List<Website> findAll() {
    return websiteRepository.findAll();
  }

  @Override
  public Website findById(UUID id) {
    Optional<Website>foundArticle=websiteRepository.findById(id);
    if (!foundArticle.isPresent())
      throw new WebsiteNotFoundException("website doesn't exists");
    return foundArticle.get();
  }

  @Override
  public Website post(CreateWebsite createWebsite) {
    Website newWebsite= new Website(
            createWebsite.getName(),
            createWebsite.getStartDate(),
            createWebsite.getEndDate(),
            createWebsite.getElapsedTime(),
            createWebsite.getDownloadedKilobytes()
    );


    return websiteRepository.save(newWebsite);
  }

  @Override
  public Website edit(UpdateWebsite updateWebsite, UUID id) {

    Optional<Website>foundArticle=websiteRepository.findById(id);
    if (!foundArticle.isPresent())
      throw new WebsiteNotFoundException("website doesn't exists");

    Website updatedWebsite=new Website(
            updateWebsite.getName(),
            updateWebsite.getStartDate(),
            updateWebsite.getEndDate(),
            updateWebsite.getElapsedTime(),
            updateWebsite.getDownloadedKilobytes()
    );

    updatedWebsite.setId(id);

    return websiteRepository.save(updatedWebsite);
  }

  @Override
  public Boolean deleteWebsite(UUID id) {
    Optional<Website>foundArticle=websiteRepository.findById(id);
    if (!foundArticle.isPresent())
      throw new WebsiteNotFoundException("article doesn't exists");

     websiteRepository.deleteById(id);
    return true;
  }
}
