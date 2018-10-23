package teknodesa.devlops.pantaujuma.components.post;

import java.util.List;

import teknodesa.devlops.pantaujuma.dependencies.models.realms.PostRealm;

public class GetPostContract {
    public interface View {
        void getAllPostSuccess(List<PostRealm> allPost);
        void getAllPostFailed(String message);

        void saveDataSuccess(String message);
        void saveDataFailed(String message);
    }

    public interface Controller {
        void getAllPost();
        void saveData(List<PostRealm> allPost);
        void getAllPostSuccess(List<PostRealm> allPost);
        void getAllPostFailed(String message);
        void saveDataSuccess(String message, PostRealm targetTemp);
        void saveDataFailed(String message);
        void updateDataRealm(PostRealm targetTemp);
    }

    public interface Repository{
        void getAllPost();
        void saveData(List<PostRealm> allPost);
    }
}
