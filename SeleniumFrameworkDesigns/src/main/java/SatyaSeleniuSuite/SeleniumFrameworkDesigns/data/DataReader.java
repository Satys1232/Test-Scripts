package SatyaSeleniuSuite.SeleniumFrameworkDesigns.data;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// Load resource from classpath
		URL resource = getClass().getClassLoader().getResource("PurchaseOrder.json");
		File file = new File(resource.getFile());
		String jsonContent = FileUtils.readFileToString(file, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
