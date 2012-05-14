//package com.ggd543.portlet;
//
//import javax.portlet.*;
//import java.io.IOException;
//
///**
// * User: ¡ı”¿Ω°
// * Date: 12-1-10
// * Time: œ¬ŒÁ3:40
// * To change this template use File | Settings | File Templates.
// */
//public class IBMPortlet extends GenericPortlet {
//
//
//    /**
//     * A sample portlet based on GenericPortlet
//     */
//    public class HelloWorldPortlet extends GenericPortlet {
//        public static final String JSP_FOLDER = "/com_ibm_spc/jsp/";    // JSP folder name
//        public static final String VIEW_JSP = "HelloWorldPortletView";
//        // JSP file name to be rendered on the view mode
//        public static final String VIEW_BEAN = "HelloWorldPortletBean";
//        // Bean name for the view mode request
//        public static final String SAY_HELLO_ACTION = "Say_Hellow_Action";   // Action name for submit form
//        public static final String YOUR_NAME = "YourName";     // Parameter name for the text input
//
//        /**
//         * Serve up the <code>view</code> mode.
//         *
//         * @see javax.portlet.GenericPortlet
//         *      #doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
//         */
//        public void doView(RenderRequest request,
//                           RenderResponse response)
//                throws PortletException, IOException {
//            // Set the MIME type for the render response
//            response.setContentType(request.getResponseContentType());
//            // Invoke the JSP to render
//            PortletRequestDispatcher rd =
//                    getPortletContext().getRequestDispatcher(getJspFilePath(request,
//                            VIEW_JSP));
//            rd.include(request, response);
//        }
//
//        /**
//         * Process an action request.
//         *
//         * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest,
//         *      javax.portlet.ActionResponse)
//         */
//        public void processAction(ActionRequest request,
//                                  ActionResponse response)
//                throws PortletException, java.io.IOException {
//            if (request.getParameter(SAY_HELLO_ACTION) != null) {
//                // Make a session bean
//                PortletSession session = request.getPortletSession();
//                HelloWorldPortletBean viewBean = new HelloWorldPortletBean();
//                session.setAttribute(VIEW_BEAN, viewBean);
//
//                System.out.println("debug HelloWorld "
//                        + request.getParameter(YOUR_NAME));
//
//                // Set form text in the view bean
//                viewBean.setFormText(request.getParameter(YOUR_NAME));
//            }
//        }
//
//        /**
//         * Returns JSP file path.
//         *
//         * @param request Render request
//         * @param jspFile JSP file name
//         * @return JSP file path
//         */
//        private static String
//        getJspFilePath(RenderRequest request, String jspFile) {
//            String markup = request.getProperty("wps.markup");
//            if (markup == null)
//                markup = getMarkup(request.getResponseContentType());
//            return JSP_FOLDER + markup + "/" + jspFile + "." +
//                    getJspExtension(markup);
//        }
//
//        /**
//         * Convert MIME type to markup name.
//         *
//         * @param contentType MIME type
//         * @return Markup name
//         */
//        private static String getMarkup(String contentType) {
//            if ("text/vnd.wap.wml".equals(contentType))
//                return "wml";
//            return "html";
//        }
//
//        /**
//         * Returns the file extension for the JSP file
//         *
//         * @param markupName Markup name
//         * @return JSP extension
//         */
//        private static String getJspExtension(String markupName) {
//            return "jsp";
//        }
//    }
//}
