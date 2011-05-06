IF NOT EXIST %WTK_HOME% (
    echo Not found WTK_HOME variable	
    goto END
)

SET MIDP_API_2_0=%WTK_HOME%\lib\midp_2.0.jar
SET CLDC_API_1_1=%WTK_HOME%\lib\cldc_1.1.jar
SET MIDP_CP=%MIDP_API_2_0%;%CLDC_API_1_1%