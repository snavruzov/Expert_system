<%@ include file="/jsp/taglibs.jsp"%>

<menu:menu id="menu">

    <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_CONTENT">
        <menu:menuSection title="section.content.menu">
            <menu:menuItem url="/content/melody" title="section.content.melody.list" />
            <menu:menuItem url="/content/joke" title="section.content.joke.list" />
            <menu:menuItem url="/content/grats" title="section.statistic.total.grate" />
            <menu:menuItem url="/content/horo" title="section.menu.horoscope" />
        </menu:menuSection>

        <menu:menuSection title="section.tops.menu.title">
            <menu:menuItem url="/tops/east" title="section.tops.menu.hit.east" />
            <menu:menuItem url="/tops/foreign" title="section.tops.menu.hit.foreign" />
            <menu:menuItem url="/tops/russ" title="section.tops.menu.hit.russ" />

            <menu:menuItem url="/tops/joke" title="section.content.joke.list" />
            <menu:menuItem url="/tops/grate" title="section.content.grats.list" />
            <menu:menuItem url="/tops/grate_holiday" title="section.content.grats_holiday.list" />
        </menu:menuSection>
        </sec:authorize>
        <sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_MONIT">
            <menu:menuSection title="section.service.menu">
               <menu:menuItem url="/service/graph" title="section.service.status"/>
            </menu:menuSection>
        </sec:authorize>

        <sec:authorize ifAnyGranted="ROLE_STATISTIC">
        <menu:menuSection title="section.statistic.menu">
            <menu:menuItem url="/statistic/total" title="section.statistic.summary.menu" />
            <menu:menuItem url="/statistic/ivrtime" title="section.statistic.timeivr.menu" />
            <menu:menuItem url="/statistic/ivrvisit" title="section.statistic.choose.ivr.menu" />
            <menu:menuItem url="/statistic/jokes" title="section.statistic.ivr.jokes.menu" />
            <menu:menuItem url="/statistic/grats" title="section.statistic.grates.ivr.menu" />
            <menu:menuItem url="/statistic/horo" title="section.statistic.horoscope.ivr.menu" />
            <menu:menuItem url="/statistic/weather" title="section.statistic.whether.ivr.menu" />
        </menu:menuSection>
        </sec:authorize>



    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <menu:menuItem url="/logs" title="section.logs.report" />
    </sec:authorize>

    <menu:menuItem url="/logout" title="section.logout.menu" />
    <script type="text/javascript">
        function show(elem)
        {
            $(".chooser").hide();
            $(".region_" + $(elem).attr("region") + "_div").show();
        }

        $(".region").click( function()
        {
            show(this);
        });

        $(".region_${stat.idRegion}_div").show();
    </script>
</menu:menu>