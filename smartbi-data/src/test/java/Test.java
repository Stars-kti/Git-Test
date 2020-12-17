import com.smartbi.data.dao.RightsAndInterestsDao;
import com.smartbi.data.entity.OrganizationCode;
import com.smartbi.data.entity.OrganizationLevel;
import com.smartbi.data.entity.OrganizationName;
import com.smartbi.data.entity.RightsAndInterests;
import com.smartbi.data.util.TxtDataInput;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test {

    @Autowired
    RightsAndInterestsDao rightsAndInterestsDao;

    public static void main(String[] args) {
        TxtDataInput txtDataInput = new TxtDataInput("C:/Users/citicsf/Documents/WeChat Files/wxid_qogswec0lyri22/FileStorage/File/2020-11/org_marketdeposit_20201116.data");
        List<String[]> data = txtDataInput.getData("\\|", 1);
        List<RightsAndInterests> rightsAndInterests = new ArrayList<>();
        for (String[] s: data) {
//            RightsAndInterests r = new RightsAndInterests(Timestamp.valueOf(s[0]),Double.parseDouble(s[3]),
//                    Double.parseDouble(s[4]),Double.parseDouble(s[5]),
//                    new OrganizationCode(s[1]),new OrganizationName(s[2]),new OrganizationLevel(s[6]));
//            rightsAndInterests.add(r);
        }

    }

}
