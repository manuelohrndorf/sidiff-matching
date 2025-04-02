<xsl:stylesheet version="2.0"
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
      xmlns="http://www.w3.org/TR/xhtml1/strict"
      xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL-XMI">

    <xsl:template match="/">
    <bpmn2:Definitions xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL-XMI" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI-XMI" id="Definitions_1">
	<xsl:copy-of select = " bpmn2:Definitions/rootElements"/>
	</bpmn2:Definitions> 
	</xsl:template>
</xsl:stylesheet>