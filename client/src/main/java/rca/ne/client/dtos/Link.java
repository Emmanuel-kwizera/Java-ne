package rca.ne.client.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Link {
    private Long id;
    private String url;
    public Link(CreateOrUpdateLinkDTO dto) {
        this.url = dto.getUrl();
    }
}
