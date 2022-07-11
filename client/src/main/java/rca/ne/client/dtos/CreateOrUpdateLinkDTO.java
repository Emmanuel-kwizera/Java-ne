package rca.ne.client.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CreateOrUpdateLinkDTO {


    @NotEmpty
    private String url;

    @NotEmpty
    private String name;

    @NotEmpty
    private long start_time;

    @NotEmpty
    private long end_time;

    @NotEmpty
    private long elapse_time;

    @NotEmpty
    private int kilobytes;

    public CreateOrUpdateLinkDTO(String url, String name, long start_time, long end_time, long elapse_time,
                                 int kilobytes) {
        this.url = url;
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.elapse_time = elapse_time;
        this.kilobytes = kilobytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public long getElapse_time() {
        return elapse_time;
    }

    public void setElapse_time(long elapse_time) {
        this.elapse_time = elapse_time;
    }

    public int getKilobytes() {
        return kilobytes;
    }

    public void setKilobytes(int kilobytes) {
        this.kilobytes = kilobytes;
    }
}
