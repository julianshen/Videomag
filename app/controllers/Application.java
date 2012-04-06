package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.youtube;

import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.util.ServiceException;

public class Application extends Controller {
  
  public static Result index() {
	//List<Task> tasks = Task.find.all();
    return ok(index.render("Your new application is ready. Test1!!"));
  }
  
  public static Result youtubeTop() {
	YouTubeService service = new YouTubeService("MyTest", "AI39si4w2Vv87Y-7KTFFZEVyL8_ylah-sxx2YHVEONVtMcW1et3JvHHXf1ew_RdUqihgvCv6bHATIfoPPaCCsuiaeD_hdCh69w");
	VideoFeed videoFeed;
	String testData="No Data";
	try {
		
		videoFeed = service.getFeed(new URL("https://gdata.youtube.com/feeds/api/standardfeeds/top_rated"), VideoFeed.class);

		testData = "";
		for(VideoEntry videoEntry : videoFeed.getEntries() ) {
		     testData += videoEntry.getHtmlLink().getHref()+",";
		  }
		
		return ok(youtube.render(videoFeed.getEntries()));
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return ok(testData); 
  }
  
}