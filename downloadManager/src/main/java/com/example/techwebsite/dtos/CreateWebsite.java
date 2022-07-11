package com.example.techwebsite.dtos;
import java.util.Date;

public class CreateWebsite {

  private String name;
  private long startDate;
  private long endDate;
  private long elapsedTime;
  private int downloadedKilobytes;
  public CreateWebsite(){}


  public CreateWebsite(String name, long startDate, long endDate, long elapsedTime, int downloadedKilobytes) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.elapsedTime = elapsedTime;
    this.downloadedKilobytes = downloadedKilobytes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getStartDate() {
    return startDate;
  }

  public void setStartDate(long startDate) {
    this.startDate = startDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  public long getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(long elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public int getDownloadedKilobytes() {
    return downloadedKilobytes;
  }

  public void setDownloadedKilobytes(int downloadedKilobytes) {
    this.downloadedKilobytes = downloadedKilobytes;
  }

  @Override
  public String toString() {
    return "Website{" +
            ", website_name='" + name + '\'' +
            ", start_time='" + startDate + '\'' +
            ", end_time='" + endDate + '\'' +
            ", elapsed_time='" + elapsedTime + '\'' +
            ", total_kilobytes=" + downloadedKilobytes +
            '}';
  }

}
