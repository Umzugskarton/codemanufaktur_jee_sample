FROM payara/server-full:5.184

# Setup configuration
USER payara
COPY postgresql-42.2.5.jar /opt/payara/appserver/glassfish/domains/production/lib/
COPY domain.xml /opt/payara/appserver/glassfish/domains/production/config/domain.xml
