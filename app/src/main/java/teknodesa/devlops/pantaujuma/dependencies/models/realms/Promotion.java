package teknodesa.devlops.pantaujuma.dependencies.models.realms;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Marthin on 2/23/2018.
 */

public class Promotion extends RealmObject {
    @PrimaryKey
    private int id;
    private String imagePromotion;
    private String description;
    private String startPromo;
    private String endPromo;
    private String codePromo;
    private int activated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePromotion() {
        return imagePromotion;
    }

    public void setImagePromotion(String imagePromotion) {
        this.imagePromotion = imagePromotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartPromo() {
        return startPromo;
    }

    public void setStartPromo(String startPromo) {
        this.startPromo = startPromo;
    }

    public String getEndPromo() {
        return endPromo;
    }

    public void setEndPromo(String endPromo) {
        this.endPromo = endPromo;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }
}
