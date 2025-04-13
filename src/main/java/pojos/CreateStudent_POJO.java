package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudent_POJO {

    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private int id;

}
