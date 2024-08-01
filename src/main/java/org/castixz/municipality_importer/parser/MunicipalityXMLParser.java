package org.castixz.municipality_importer.parser;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.castixz.municipality_importer.dto.MunicipalityDTO;
import org.castixz.municipality_importer.dto.MunicipalityPartDTO;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class MunicipalityXMLParser {

    private final MunicipalityParsingResultManager municipalityParsingResultManager;


    @SneakyThrows
    public MunicipalityParsingResult parse(Path path) {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var document = builder.parse(path.toString());
        document.getDocumentElement().normalize();
        this.parseMunicipalities(document);
        this.parseMunicipalitiesParts(document);
        return municipalityParsingResultManager.getResult();
    }

    private void parseMunicipalitiesParts(Document document) {
        var partsList = document.getElementsByTagName("vf:CastObce");
        for (int j = 0; j < partsList.getLength(); j++) {
            Node partNode = partsList.item(j);

            if (partNode.getNodeType() == Node.ELEMENT_NODE) {
                var partElement = (Element) partNode;
                var code = partElement.getElementsByTagName("coi:Kod").item(0).getTextContent();
                var name = partElement.getElementsByTagName("coi:Nazev").item(0).getTextContent();
                var nestedMunicipalityElement = (Element) partElement.getElementsByTagName("coi:Obec").item(0);
                var municipalityCode = nestedMunicipalityElement.getElementsByTagName("obi:Kod").item(0).getTextContent();
                municipalityParsingResultManager.addMunicipalityPart(MunicipalityPartDTO.builder()
                        .code(code)
                        .name(name)
                        .mainMunicipality(municipalityCode)
                        .build());
            }
        }
    }

    private void parseMunicipalities(Document document) {
        var municipalityList = document.getElementsByTagName("vf:Obec");
        for (int i = 0; i < municipalityList.getLength(); i++) {
            var node = municipalityList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                var element = (Element) node;
                var code = element.getElementsByTagName("obi:Kod").item(0).getTextContent();
                var name = element.getElementsByTagName("obi:Nazev").item(0).getTextContent();
                municipalityParsingResultManager.addMunicipality(MunicipalityDTO.builder()
                        .code(code)
                        .name(name)
                        .build());
            }
        }
    }
}
