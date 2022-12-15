package eapli.base.service.domain;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.domain.model.DomainFactory;

import java.util.Set;

public class ServiceBuilder implements DomainFactory<Service> {

    private Title title;
    private String briefDescription;
    private String description;
    private Code code;
    private Icon icon;
    private Catalogue catalogue;
    private Set<Keyword> keywords;

    public ServiceBuilder withTitle(Title title) {
        this.title = title;
        return this;
    }

    public ServiceBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    public ServiceBuilder withBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
        return this;
    }

    public ServiceBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ServiceBuilder withCode(Code code) {
        this.code = code;
        return this;
    }

    public ServiceBuilder withCode(String code) {
        this.code = new Code(code);
        return this;
    }

    public ServiceBuilder withIcon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public ServiceBuilder withIcon(String icon) {
        this.icon = new Icon(icon);
        return this;
    }

    public ServiceBuilder withCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
        return this;
    }

    public ServiceBuilder withKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    public boolean isComplete(){
        if(this.title == null || this.description == null || this.briefDescription == null ||
                this.description == null || this.code == null || this.icon == null ||
                this.catalogue == null || this.keywords == null)
            return false;
        return true;
    }

    public boolean isNew(){
        if(this.title == null && this.description == null && this.briefDescription == null &&
                this.description == null && this.code == null && this.icon == null &&
                this.catalogue == null && this.keywords == null)
            return true;
        return false;
    }

    public Title getTitle() {
        return title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getDescription() {
        return description;
    }

    public Code getCode() {
        return code;
    }

    public Icon getIcon() {
        return icon;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    @Override
    public Service build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Service(this.title, this.briefDescription, this.description, this.code, this.icon, this.catalogue, this.keywords);
    }
}


