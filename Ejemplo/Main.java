import MVCManager.MVCData;
import MVCManager.MVCFramework;
import TEST.TEST;
import TEST.TESTView;

public class Main {
    public static void main(String args[]) {

        TEST service = new TEST("test");
        TESTView view = new TESTView();
        MVCData data = new MVCData(
                "test_controller",
                "test_model",
                "view_test",
                view,
                service);
        MVCFramework mvc = new MVCFramework(data);
        mvc.execute();
    }
}
