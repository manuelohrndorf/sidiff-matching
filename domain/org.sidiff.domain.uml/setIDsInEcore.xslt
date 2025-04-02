<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" >

<!-- Author: Sven Wenzel -->

<!-- ID-Attribut von UMLElement als solches markieren -->
<xsl:template match="eStructuralFeatures[@name='id' and ../@name='UMLElement']">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
<xsl:attribute name="iD">true</xsl:attribute>
</xsl:copy>
</xsl:template>

<!-- Rest kopieren -->
<xsl:template match="@* | node()">
<xsl:copy>
<xsl:apply-templates select="@* | node()"/>
</xsl:copy>
</xsl:template>

</xsl:stylesheet>
