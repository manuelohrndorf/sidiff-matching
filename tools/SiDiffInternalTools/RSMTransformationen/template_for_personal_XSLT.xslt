<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" >

<!-- Copy the rest -->
<xsl:template match="@* | node()">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
</xsl:copy>
</xsl:template>

<!-- Here you can define templates for specific elements. The rest of the input file will be copied. -->



</xsl:stylesheet>
