package rca.ne.client.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class CreateOrUpdateLinkDTO {


    @NotEmpty
    private String url;

    public CreateOrUpdateLinkDTO(String url) {
        this.url = url;
    }
}
