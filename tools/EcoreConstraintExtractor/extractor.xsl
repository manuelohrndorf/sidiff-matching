<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" />
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
		
	<xsl:template match="eClassifiers">
	<xsl:text>----------------------------------------------------------------</xsl:text>
		<xsl:text>&#xa;</xsl:text>
		<xsl:text>:::</xsl:text><xsl:value-of select="local-name()"/>:::<xsl:value-of select="@name"/>:
		<xsl:text>&#xa;</xsl:text>
		
		<xsl:if test="./@eSuperTypes">
			<xsl:text>Inherits from: </xsl:text><xsl:value-of select="@eSuperTypes"/>
			<xsl:text>&#xa;</xsl:text>	
		</xsl:if>
		
		<xsl:value-of select="eAnnotations/details/@value"/>
		
		<xsl:apply-templates/>
		<xsl:text>&#xa;</xsl:text>
	</xsl:template>
	
	<xsl:template match="eOperations">
		<xsl:if test="./eAnnotations">
			<xsl:text>&#xa;</xsl:text><xsl:text>&#xa;</xsl:text>
			<xsl:text>-</xsl:text><xsl:value-of select="local-name()"/>:<xsl:value-of select="@name"/>:
			<xsl:text>&#xa;</xsl:text>
			<xsl:value-of select="eAnnotations/details/@value"/>
			<xsl:text>&#xa;</xsl:text>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="eParameters">
		<xsl:if test="./eAnnotations">
			<xsl:text>&#xa;</xsl:text><xsl:text>&#xa;</xsl:text>
			<xsl:text>-</xsl:text><xsl:value-of select="local-name()"/>:<xsl:value-of select="@name"/>:
			<xsl:text>&#xa;</xsl:text>
			<xsl:value-of select="eAnnotations/details/@value"/>
			<xsl:apply-templates/>
			<xsl:text>&#xa;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template match="eStructuralFeatures">
		<xsl:if test="./eAnnotations">
			<xsl:text>&#xa;</xsl:text><xsl:text>&#xa;</xsl:text>
			<xsl:text>-</xsl:text><xsl:value-of select="local-name()"/>:<xsl:value-of select="@name"/>:
			<xsl:text>&#xa;</xsl:text>
			<xsl:value-of select="eAnnotations/details/@value"/>
			<xsl:text>&#xa;</xsl:text>
		</xsl:if>
	</xsl:template>
	
		<xsl:template match="contents">
		<xsl:if test="./eAnnotations">
			<xsl:text>&#xa;</xsl:text><xsl:text>&#xa;</xsl:text>
			<xsl:text>-</xsl:text><xsl:value-of select="local-name()"/>:<xsl:value-of select="@name"/>:
			<xsl:text>&#xa;</xsl:text>
			<xsl:value-of select="eAnnotations/details/@value"/>
			<xsl:text>&#xa;</xsl:text>
		</xsl:if>
	</xsl:template>

	<xsl:template match="*/text()[not(normalize-space())]" />
</xsl:stylesheet>