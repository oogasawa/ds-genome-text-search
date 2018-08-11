package jp.ac.nig.ddbj.webapp.dstextsearch.controller;

import jp.ac.nig.ddbj.webapp.dstextsearch.dao.ResultInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller that demonstrates tiles mapping, reguest parameters and path variables.
 * 
 * @author Mark Meany
 */
@Controller
public class MainController {
	private Log log = LogFactory.getLog(this.getClass());

	@Value("${datafile}")
	String datafile;


    @RequestMapping(value = "/search", method={GET,POST})
	public ModelAndView home(@RequestParam(value="query", defaultValue="") String query,
							 @RequestParam(value="case", defaultValue="insensitive") String regexMode) {

    	ArrayList<ResultInfo> list = new ArrayList<>();
    	Pattern p = null;

    	if (query.length() > 0) {
    		if (regexMode.equals("insensitive")) {
				p = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
			}
			else {
    			p = Pattern.compile(query);
			}

		}

		try (Scanner scanner = new Scanner(new File(datafile))) {
			while (scanner.hasNext()) {
				ResultInfo r = new ResultInfo();
				String line = scanner.nextLine();

				if (p != null) {
					Matcher m = p.matcher(line);
					if (m.find()) {
						//System.out.println(line);
						r.parse(line);
						if (!r.isNull()) {
							list.add(r);
							//System.out.println(r.getLine());
						}
					}
				}
				else {
					r.parse(line);
					if (!r.isNull()) {
						list.add(r);
						//System.out.println(r.getLine());
					}
				}


			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		TreeMap<String, Object> model = new TreeMap<>();
		model.put("resultInfoList", list);
		model.put("query", query);
		model.put("regexMode", regexMode);

    	return new ModelAndView("site.homepage", model);
	}

	/*
	@RequestMapping(value = "/greet", method=RequestMethod.GET)
	public ModelAndView greet(@RequestParam(value = "name", required=false, defaultValue="World!")final String name, final Model model) {
		log.info("Controller has been invoked with Request Parameter name = '" + name + "'.");
		return new ModelAndView("site.greeting", "name", name);
	}
	*/

	@RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
	public ModelAndView greetTwoWays(@PathVariable(value="name") final String name, final Model model) {
		log.info("Controller has been invoked with Path Variable name = '" + name + "'.");
		return new ModelAndView("site.greeting", "name", name);
	}

}
