using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using HappyCommunity.Types;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.Sqlite;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace HappyCommunity.Controllers
{
	[Route("api/[controller]")]
	public class GetMyTasks : Controller
	{
		[HttpGet("{info}")]
		public IEnumerable<PostOverviewModel> Get(HttpRequestMessage request, string username, int status)
		{
			List<PostOverviewModel> Posts = new List<PostOverviewModel>();
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = $"Select Posts.id, Title, Reward, Posts.Name, City, Posts.UserName FROM Posts Inner JOIN PostTask INNER JOIN Users ON Posts.UserName = Users.UserName AND Posts.ID = PostTask.ID AND PostTask.UserHandlingTask = \"{username}\" AND PostTask.Status = {status};";

				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							Posts.Add(new Types.PostOverviewModel()
							{
								Id = Int32.Parse(rdr["ID"].ToString()),
								Title = rdr["Title"].ToString(),
								Reward = Int32.Parse(rdr["Reward"].ToString()),
								Name = rdr["Name"].ToString(),
								City = rdr["City"].ToString(),
								UserName = rdr["UserName"].ToString()

							});
						}
					}
				}
			}


			return Posts;


		}

	}


}
