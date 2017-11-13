package jszczepankiewicz.gatewayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jszczepankiewicz
 * @since 2017-11-13
 */
@Component
public class AccessLogFilter  extends ZuulFilter {
  Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

    logger.info("REQ " + request.getScheme() + " " + request.getLocalAddr() + ":" + request.getLocalPort()
            + " " + request.getMethod() + " " + request.getRequestURI() + " > " + response.getStatus());

    return null;
  }
}

