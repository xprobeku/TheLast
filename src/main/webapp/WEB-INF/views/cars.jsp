<%--
  Created by IntelliJ IDEA.
  User: asdf
  Date: 2/5/2020
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>

<html>

<body>
<div id="cars">
    <h3>Car Management</h3>

    <div >
        <p id="nodata">No result found, please try again.</p>
        <table id="table" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>#</th>
                <th>carBrand</th>
                <th>model</th>
                <th>year</th>
                <th>price</th>
                <th>seats</th>
                <th>firstName</th>
                <th>lastName</th>
                <th>phone</th>
            </tr>
            </thead>
        </table>
    </div>
    <script>

        var table;
        $(function () {
            $(document).ajaxStart(function(){ $("#loader").show(); })
                .ajaxStop(function() { $("#loader").hide(); });
            $("div.result").hide ();
            $.get("rest/cars/list")
                .success(function (data) {
                    var myJSON = JSON.stringify(data);

                    alert(myJSON);
                    $("div.result").show();
                    if (myJSON.length == 0) {
                        $("#table").hide();
                        $("#nodata").show();
                    } else {
                        $("#table").show();
                        $("#nodata").hide();

                        if (table)
                            table.destroy();


                        table = $('#table').DataTable({
                            "Data": myJSON,
                            "pageLength": 5,
                            "Columns": [
                                {"data": "carBrand"},
                                {"data": "model"},
                                {"data": "year"},
                                {"data": "price"},
                                {"data": "seats"},
                                {"data": "owner"},
                                {"data": "description"},
                                {"data": "isAvailable"},
                                { "data": "id",
                                    "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                                        $(nTd).html("<a href='cars/update/" + oData.id + "'>Edit</a>");
                                    }
                                }
                            ]
                        });
                    }
                })
                .fail(function (data) {
                    console.log(data);
                });
        });
    </script>

    <a href="/cars/add" id="addLnk" class="btn btn-success">Add car</a>
</div>
</body>
</html>
