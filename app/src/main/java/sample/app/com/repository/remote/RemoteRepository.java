package sample.app.com.repository.remote;


import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RemoteRepository {

    @FormUrlEncoded
    @POST("InitDevice.json")
    Single<String> initDevice(@Field("udid") String uniqueDeviceId);

}